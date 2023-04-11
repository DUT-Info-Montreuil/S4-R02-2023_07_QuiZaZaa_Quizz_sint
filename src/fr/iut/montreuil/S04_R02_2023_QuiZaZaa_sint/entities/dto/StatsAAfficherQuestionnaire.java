package fr.iut.montreuil.S04_R02_2023_QuiZaZaa_sint.entities.dto;

import java.util.ArrayList;

public class StatsAAfficherQuestionnaire {
	
	private int idQuestionnaire;
	private int nbFoisJoue;
	private ArrayList<StatsAAfficherQuestion> statsQuestions;
	
	
	public StatsAAfficherQuestionnaire(int idQuestionnaire, int nbFoisJoue,
			ArrayList<StatsAAfficherQuestion> statsQuestions) {
		super();
		this.idQuestionnaire = idQuestionnaire;
		this.nbFoisJoue = nbFoisJoue;
		this.statsQuestions = statsQuestions;
	}
	
	
	

}
