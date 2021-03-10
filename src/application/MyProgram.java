package application;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import business.GererLivre;
import business.GererNvEmp;
import entities.Emprunt;
import entities.Exemplaire;
import entities.Livre;
import serviceImp.DAOImpGererLivre;
import serviceImp.DAOImpGererNouveauEmprunt;

public class MyProgram {

	public static void main(String[] args) {
		
		
		System.out.print("tapez 1 pour la gestion des livres\n");
		System.out.print("tapez 2 pour la gestion des nouveaux emprunts\n");
		
		Scanner input1 = new Scanner(System.in);
		String in=input1.nextLine();
		if (in.equals("1")) {
			DAOImpGererLivre daoImpGererLivre= new DAOImpGererLivre();
			GererLivre gererLivre=new GererLivre(daoImpGererLivre);
			System.out.print("tapez 1 pour ajouter un livre\n");
			System.out.print("tapez 2 pour supprimer un livre\n");
			System.out.print("tapez 3 pour lister les livres\n");
			System.out.print("tapez 4 pour chercher un livre\n");

			Scanner input2 = new Scanner(System.in);
			String in2=input2.nextLine();
			if(in2.equals("1")) {
				System.out.print("Titre:  ");
				Scanner inputTitre = new Scanner(System.in);
				String titre=inputTitre.nextLine();
				System.out.print("Theme:  ");
				Scanner inputTheme = new Scanner(System.in);
				String theme=inputTheme.nextLine();
				System.out.print("Auteur: ");
				Scanner inputAuteur = new Scanner(System.in);
				String auteur=inputAuteur.nextLine();
				System.out.print("Nombre d'exemplaire de ce livre: ");
				Scanner inputNbExmp = new Scanner(System.in);
				String nbExmp=inputNbExmp.nextLine();
				Livre livre=new Livre(titre, theme, auteur);
				boolean done=gererLivre.insererLivre(livre,
						new Exemplaire(livre.getTitre(),livre.getTheme(),livre.getAuteur()),Integer.parseInt(nbExmp));		
				if (done)
					System.out.print("done");
				else
					System.out.print("echec");
			}
			else if(in2.equals("2")) {
				System.out.print("Donner isbn du livre a supprimer:\n");
				Scanner inputIsbn = new Scanner(System.in);
				String isbn=inputIsbn.nextLine();
				boolean done=gererLivre.deleteLivre(Integer.parseInt(isbn));
				if (done)
					System.out.print("done");
				else
					System.out.print("echec");
			}
			else if(in2.equals("3")) {
				List<Livre> listeLivre=gererLivre.listerLivres();
				int i=0;
				if(listeLivre.size()>0){
					while(i<listeLivre.size()) {
						System.out.print(listeLivre.get(i).toString());			
						i++;
					}
				}
			}
			else if(in2.equals("4")) {
				System.out.print("Donner isbn du livre a chercher:\n");
				Scanner inputIsbn = new Scanner(System.in);
				String isbn=inputIsbn.nextLine();
				Livre livre =gererLivre.findLivre(Integer.parseInt(isbn));
				System.out.print(livre.toString());	
			}
			
		}
		else if (in.equals("2")) {
			System.out.print("tapez 1 pour ajouter un nouveau emprunt\n");
			System.out.print("tapez 2 pour supprimer un emprunt\n");
			System.out.print("tapez 3 pour lister les emprunts\n");
			Scanner input2 = new Scanner(System.in);
			String in2=input2.nextLine();
			DAOImpGererNouveauEmprunt daoImpGererNvEmp= new DAOImpGererNouveauEmprunt();
			GererNvEmp gererNvEmp= new GererNvEmp(daoImpGererNvEmp);
			
			if(in2.equals("1")) {
				System.out.print("Donnez l'ID de l'etudiant :");
				Scanner inputidEtud = new Scanner(System.in);
				int idEtud=Integer.parseInt(inputidEtud.nextLine());
				Date aujourdhui = new Date();
				DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
				        DateFormat.SHORT,
				        DateFormat.SHORT);
				String DE=shortDateFormat.format(aujourdhui);
				String DRE=null;
				System.out.print("Donnez le code Exemplaire :");
				Scanner inputcodeExemplaire = new Scanner(System.in);
				int codeExemp=Integer.parseInt(inputcodeExemplaire.nextLine());
				boolean done=gererNvEmp.insererNouveauEmprunt(new Emprunt(DE, idEtud, codeExemp));
				if (done)
					System.out.print("done");
				else
					System.out.print("echec");
			}
			else if(in2.equals("2")) {
				System.out.print("Donnez ID de l'emprunt a supprimer:");
				Scanner inputidEmp = new Scanner(System.in);
				int idEmp=Integer.parseInt(inputidEmp.nextLine());
				boolean done=gererNvEmp.deleteEmprunt(idEmp);
				if (done)
					System.out.print("done");
				else
					System.out.print("echec");
			}
			else if(in2.equals("3")) {
				List<Emprunt> listeEmprunt=gererNvEmp.listerEmprunts();
				int i=0;
				if(listeEmprunt.size()>0){
					while(i<listeEmprunt.size()) {
						System.out.print(listeEmprunt.get(i).toString());			
						i++;
					}
				}else
					System.out.println("vide");
			}
			
		}
		
	}

}
