package fr.iut.montreuil.S04_R02_2023_QuiZaZaa_sint.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.StatsDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl.ServiceJoueurImpl;

import fr.iut.montreuil.S04_R02_2023_QuiZaZaa_sint.modeles.IServiceSintJoueur;
import fr.iut.montreuil.S04_R02_2023_QuiZaZaa_sint.modeles.StatsSintDTO;

public class ServiceJoueurSintImpl implements IServiceSintJoueur{
	
	@Override
	public Map<String, StatsSintDTO> recupStatsJoueur() {
		ServiceJoueurImpl serv = new ServiceJoueurImpl();
		Map<String, StatsSintDTO> map = new HashMap<String, StatsSintDTO>();
		List<JoueurDTO> listJoueurs = serv.listerJoueur();
		
		
		for (JoueurDTO j : listJoueurs) {
			int nbParties = 0, nbQuestions = 0, nbBonnesReponses = 0, duree = 0;
			for(StatsDTO s : j.getStats()) {
				nbParties ++;
				nbQuestions =+ s.getNbrQuestions();
				nbBonnesReponses =+ s.getNbrBonneReponse();
				duree =+ s.getDuree();
			}
			
			double[] moyenne = calculMoyenneEtTemps(nbParties, nbBonnesReponses, duree);
			StatsSintDTO stats = new StatsSintDTO(nbParties, nbQuestions, nbBonnesReponses, duree, moyenne[0], moyenne[1]);
			map.put(j.getPseudo(), stats);
		}
		return map;
	}

	private double[] calculMoyenneEtTemps(int nbParties, int nbBonnesReponses, int duree) {
		double[] moyennes = new double[2];
		moyennes[0] = nbBonnesReponses/nbParties;
		moyennes[1] = duree/nbParties;
		return moyennes;
	}
	
	

}
