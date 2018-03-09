package UTP171;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class CountryTable {

	private CountryTableModel model;
	
	public CountryTable(String countriesFileName) {
		Country[] countries = loadCountriesFromFile(countriesFileName);
		String[] columnNames = loadColumnNames(countriesFileName);
		List<Country> data = Arrays.asList(countries);
		model = new CountryTableModel(data, columnNames);
	}
	
	public JTable create() {
		JTable jt = new JTable(model);
		jt.getColumnModel().getColumn(2).setCellRenderer(new PopulationCellRenderer());
		jt.setRowHeight(40);
		jt.getColumnModel().getColumn(3).setPreferredWidth(40);
		return jt;
	}
	
	private String[] loadColumnNames(String path) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String s;
			s = br.readLine();
			br.close();
			Scanner scan = new Scanner(s);
			int columnNamesCounter = 0;
			while(scan.hasNext())  {
				scan.next();
				columnNamesCounter++;
			}
			scan.close();
			scan = new Scanner(s);
			String[] columnNames = new String[columnNamesCounter];
			for(int i = 0; i < columnNamesCounter; i++) {
				if(scan.hasNext()) {
					columnNames[i] = scan.next();
				}
			}
			scan.close();
			return columnNames;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Country[] loadCountriesFromFile(String path) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String s;
			StringBuffer sb = new StringBuffer();
			int countryCounter = 0;
			br.readLine();	//wczytanie naglowkow do nikad, tu ich nie potrzebujemy
			while((s = br.readLine()) != null) {
				sb.append(s + "\n");
				countryCounter++;
			}
			br.close();
			Country[] countries = new Country[countryCounter];
			s = sb.toString();
			Scanner scan = new Scanner(s).useDelimiter("[\\t\\n\\r]");
			for(int i = 0; i < countryCounter; i++) {
				String name, capital, flag;
				int population;
				if(scan.hasNext()) {
					name = scan.next();
				} else {
					name = "";
				}
				if(scan.hasNext()) {
					capital = scan.next();
				} else {
					capital = "";
				}
				if(scan.hasNextDouble()) {
					population = (int)(scan.nextDouble()*1000); //tu te tysiace na miliony zmieniam
				} else {
					population = 0;
				}
				if(scan.hasNext()) {
					flag = scan.next();
				} else {
					flag = "";
				}
				countries[i] = new Country(name, capital, population, getFlag(flag));
			}
			scan.close();
			return countries;
		} catch(IOException exc) {
			exc.printStackTrace();
			return null;
		}
	}
	
	private ImageIcon getFlag(String countryCode) {
		if(countryCode == "") return null;
		try {
			BufferedImage bi = ImageIO.read(new File("data/images/"+countryCode+".png"));
			ImageIcon imageIcon = new ImageIcon(bi);
			Image image = imageIcon.getImage();
			Image newimg = image.getScaledInstance(80, 40,  java.awt.Image.SCALE_SMOOTH);  
			imageIcon = new ImageIcon(newimg);
			return imageIcon;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
