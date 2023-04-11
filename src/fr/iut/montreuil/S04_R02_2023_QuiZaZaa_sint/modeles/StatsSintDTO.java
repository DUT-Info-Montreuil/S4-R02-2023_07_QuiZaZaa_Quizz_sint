package fr.iut.montreuil.S04_R02_2023_QuiZaZaa_sint.modeles;

public class StatsSintDTO {
	int nbParties, nbQuestions, nbBonnesReponses, duree;
	double moyenneReponses, moyenneTemps;
	public StatsSintDTO(int nbParties, int nbQuestions, int nbBonnesReponses, int duree, double moyenneReponses, double moyenneDuree) {
		this.nbParties = nbParties;
		this.nbQuestions = nbQuestions;
		this.nbBonnesReponses = nbBonnesReponses;
		this.duree = duree;
		this.moyenneReponses = moyenneReponses;
		this.moyenneTemps = moyenneDuree;
	}



}
