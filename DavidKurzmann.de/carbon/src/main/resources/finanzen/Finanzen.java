package finanzen;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


	@Named
	@SessionScoped
	public class Finanzen implements Serializable{
		
		private int minUmsatz =20; 
		private int maxUmsatz = 40;
		private int minMarketCap =50;
		private int maxMarketCap =50;
		private String[] selectedRegions;
		private List<String> regions;
		private String message = "";
		private String Region= "Europa";
		private boolean render = true;
		
		@PostConstruct
	    public void init() {
	        regions = new ArrayList<String>();
	        regions.add("Europa");
	        regions.add("Nordamerika");
	        regions.add("Asien - Pazifik");
	        regions.add("Mittel- und Südamerika");
	        regions.add("Afrika und Naher Osten");
		}
		
		   public String[] getSelectedRegions() {
		        return selectedRegions;
		    }
		 
		    public void setSelectedCities(String[] selectedRegions) {
		        this.selectedRegions = selectedRegions;
		    }
		    public List<String> getRegions() {
		        return regions;
		    }
		public String getReichweite() {
			return Region;
		}
		public void setReichweite(String reichweite) {
			this.Region = reichweite;
		}
		public boolean isRender() {
			return render;
		}
		public void setRender(boolean render) {
			this.render = render;
		}
		public int getMinUmsatz() {
			return minUmsatz;
		}
		public int getMaxUmsatz() {
			return maxUmsatz;
		}

	    public void testButtonActionListener(ActionEvent event) {
	        System.out.println("testButtonActionListener invoked");
	    }


		public void setMinUmsatz(int umsatz) {
			this.minUmsatz=umsatz;
		}
		public void setMaxUmsatz(int umsatz) {
			this.maxUmsatz=umsatz;
		}

		public void setLand(String land) {
			this.Region=land;
		}
		public String getmessage() {
			return "hallo"+ minUmsatz;
		}

		public int getMinMarketCap() {
			return minMarketCap;
		}

		public void setMinMarketCap(int minMarketCap) {
			this.minMarketCap = minMarketCap;
		}

		public int getMaxMarketCap() {
			return maxMarketCap;
		}

		public void setMaxMarketCap(int manMarketCap) {
			this.maxMarketCap = manMarketCap;
		}

	}

