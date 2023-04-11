package fr.iut.montreuil.S04_R02_2023_QuiZaZaa_sint.impl;

import java.util.ArrayList;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_questionnaire_sme.entities.dto.QuestionDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_questionnaire_sme.entities.dto.QuestionnaireDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_questionnaire_sme.entities.exception.QuestionnaireVideException;
import fr.iut.montreuil.S04_R02_2023_QuiZaZaa_sint.entities.dto.StatsAAfficherQuestion;
import fr.iut.montreuil.S04_R02_2023_QuiZaZaa_sint.entities.dto.StatsAAfficherQuestionnaire;
import fr.iut.montreuil.S04_R02_2023_QuiZaZaa_sint.modeles.IServiceQuiz;

public class ServiceQuizImpl implements IServiceQuiz {

	@Override
	public StatsAAfficherQuestion questionMeilleurTaux(QuestionnaireDTO questionnaire)  {
		ArrayList<QuestionDTO> list = questionnaire.getListeQuestions();
		QuestionDTO mQ = null;
		if (list.isEmpty()) {
			throw new QuestionnaireVideException();
		} else {
			mQ = list.get(0);
			for (QuestionDTO q : list){
				if (tauxBonneReponse(q) > tauxBonneReponse(mQ))
					mQ = q;
			}
		}
		return new StatsAAfficherQuestion(mQ.getQuestion(), mQ.getStats().getNbBonneReponses(), mQ.getStats().getNbMauvaisesReponses());
	}

	@Override
	public StatsAAfficherQuestion questionPireTaux(QuestionnaireDTO questionnaire) {
		ArrayList<QuestionDTO> list = questionnaire.getListeQuestions();
		QuestionDTO pQ = null;
		if (list.isEmpty()) {
			throw new QuestionnaireVideException();
		} else {
			pQ = list.get(0);
			for (QuestionDTO q : list){
				if (tauxBonneReponse(q) < tauxBonneReponse(pQ))
					pQ = q;
			}
		}
		return new StatsAAfficherQuestion(pQ.getQuestion(), pQ.getStats().getNbBonneReponses(), pQ.getStats().getNbMauvaisesReponses());
	}
	
	@Override
	public double tauxBonneReponse(QuestionDTO question) {
		int bonneReponse = question.getStats().getNbBonneReponses();
		int mauvaiseReponse = question.getStats().getNbMauvaisesReponses();
		double total = bonneReponse+mauvaiseReponse;
		if (total == 0.0)
			return 0;
		return bonneReponse/total;
	}

	@Override
	public StatsAAfficherQuestionnaire recupStatsQuestionnaires(QuestionnaireDTO questionnaire) {
		ArrayList<StatsAAfficherQuestion> listeStatsQuestions = new ArrayList<StatsAAfficherQuestion>();
		for (QuestionDTO q : questionnaire.getListeQuestions())
			listeStatsQuestions.add(q.getQuestion(), q.getStats().getNbBonneReponses(), q.getStats().getNbMauvaisesReponses());
		return new StatsAAfficherQuestionnaire(questionnaire.getIdQuestionnaire(), questionnaire.getStats().getNbFoisJoue(), listeStatsQuestions);
	}
	
	

}
