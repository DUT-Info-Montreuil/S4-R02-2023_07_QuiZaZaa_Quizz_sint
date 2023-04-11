package fr.iut.montreuil.S04_R02_2023_QuiZaZaa_sint.modeles;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_questionnaire_sme.entities.dto.QuestionDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_questionnaire_sme.entities.dto.QuestionnaireDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_questionnaire_sme.entities.exception.QuestionnaireVideException;
import fr.iut.montreuil.S04_R02_2023_QuiZaZaa_sint.entities.dto.StatsAAfficherQuestion;
import fr.iut.montreuil.S04_R02_2023_QuiZaZaa_sint.entities.dto.StatsAAfficherQuestionnaire;

public interface IServiceQuiz {
	
	public StatsAAfficherQuestion questionMeilleurTaux(QuestionnaireDTO questionnaire);
	public StatsAAfficherQuestion questionPireTaux(QuestionnaireDTO questionnaire);
	public double tauxBonneReponse(QuestionDTO question);
	public StatsAAfficherQuestionnaire recupStatsQuestionnaires(QuestionnaireDTO questionnaire);

}
