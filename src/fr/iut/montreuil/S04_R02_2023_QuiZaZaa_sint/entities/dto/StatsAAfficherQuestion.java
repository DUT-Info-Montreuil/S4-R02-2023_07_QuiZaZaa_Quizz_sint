package fr.iut.montreuil.S04_R02_2023_QuiZaZaa_sint.entities.dto;

public class StatsAAfficherQuestion {
	
	private String libelleQuestion;
	private int nbBonneReponses;
	private int nbMauvaisesReponses;
	
	public StatsAAfficherQuestion(String libelleQuestion, int nbBonneReponses, int nbMauvaisesReponses) {
		super();
		this.libelleQuestion = libelleQuestion;
		this.nbBonneReponses = nbBonneReponses;
		this.nbMauvaisesReponses = nbMauvaisesReponses;
	}
	
	
}
