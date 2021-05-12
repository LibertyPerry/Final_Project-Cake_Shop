import java.util.Scanner;

public class Cake_Shop {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Cake Shop");
		System.out.print("Enter name for order: ");
		String name = input.nextLine();
		double shape = 0;
		while (shape != 1 && shape != 2){
			System.out.println("Would you like a Round or a Rectangle cake?");
			System.out.print("(1 Round, 2 Rectangle) : " );
			shape = input.nextDouble();
			if (shape != 1 && shape != 2) {
				System.out.println("INCORRECT VALUE");
			}
		}
		if (shape == 1) {
			System.out.println("Round Cake Selected");
		}else if (shape == 2) {
			System.out.println("Rectangle Cake Selected");
		}
		System.out.print("How many tiers of cake do you want? ");
		int tiers = input.nextInt();
		double Volume = 0;
		double Circumference = 0;
		double SurfaceArea = 0;
		double Total_Price = 0;
		double Base_Price = 0;
		double Fondant_Price = 0;
		String[] Flavors = new String[tiers];
		String[] Icing = new String[tiers];
		// Creating the tiers of cake and adding the prices of each to the total price
		for(int x = 0; tiers > x; x++) {
			if (shape == 1) {
				System.out.print("Enter cake dimensions\n"
				+ "Diameter: ");
				double diameter = input.nextDouble();
				double radius = diameter / 2;
				System.out.print("Height: ");
				double height = input.nextDouble();
				Cylinder cake = new Cylinder(radius, height);
				Volume = cake.getVolume();
				Circumference = cake.getCircumference();
				SurfaceArea = cake.getSurfaceArea();
					Base_Price = Volume / 4;
					if(Base_Price < 12) {
						Base_Price = 12;
					}
					Total_Price += Base_Price;
			}else if(shape == 2) {
				System.out.print("Enter cake dimension\n"
					+ "Length: ");
				double length = input.nextDouble();
				System.out.print("Width: ");
				double width = input.nextDouble();
				System.out.print("Height: ");
				double height = input.nextDouble();
				Rectangle_Prism cake = new Rectangle_Prism(length, width, height);
				Volume = cake.getVolume();
				Circumference = cake.getCircumference();
				SurfaceArea = cake.getSurfaceArea();
					Base_Price = Volume / 6;
					if (Base_Price < 15.00) {
						Base_Price = 15;
					}
					Total_Price += Base_Price;
			}
			System.out.print("Layer " + (x+1) + " Flavor: ");
			String flavor = input.next(); 
			Flavors[x] = flavor;
			double icing_type = 0;
			while (icing_type != 1 && icing_type != 2){
			System.out.print("Do you want Buttercream Icing or Fondant?\n"
					+ "(Fondant costs extra)\n"
					+ "1) Butter Cream, 2)Foundant : ");
			icing_type = input.nextInt();
			if (icing_type != 1 && icing_type != 2) {
				System.out.println("INCORRECT VALUE");
				}
			}
			if (icing_type == 2) {
				Fondant_Price = SurfaceArea * 0.1;
				Total_Price += Fondant_Price;
			}
			System.out.print("Layer " + (x+1) + " Icing color: ");
			String icing = input.next(); 
			Icing[x] = icing;
			System.out.println("Tier Created");
			System.out.println();
		}
		int decorations = 0;
		while(decorations != 1 && decorations != 2) {
			System.out.print("Would you like any Decorations on your cake?\n"
				+ "(ex : Lettering, or Buttercream decal)\n"
				+ "(1 Yes, 2 No) : ");
			decorations = input.nextInt();
			if(decorations != 1 && decorations != 2) {
				System.out.println("INCORRECT VALUE");
			}
		}
		String Ldescription = " ";
		String lettering = " ";
		String frostingDecal = " ";
		if (decorations == 1) {
			int menu = 0;
			while(menu != 3) {
				System.out.print("Decorations Menu:\n"
					+ "1. Lettering\n"
					+ "2. Frosting Decal\n"
					+ "3. Exit\n"
					+ "Enter choice: ");
				menu = input.nextInt();
			if (menu == 1) {
				int letters = 0;
				System.out.print("What would you like your lettering to say? ");
				lettering = input.next();
				for (int i = 0; i < lettering.length(); i++) {
					if (lettering.charAt(i) != ' ') {
						letters += 1;
					}
				}
				System.out.println();
				System.out.print("Any special instructions: ");
				Ldescription = input.next();
				double Lprice = letters * 0.50;
				Total_Price += Lprice;
				System.out.println();
			}
			if (menu == 2) {
				System.out.print("What would you like your buttercream decal to look like?");
				frostingDecal = input.next();
				int NumDecal = 0;
				System.out.print("How many decal do you want: ");
				NumDecal = input.nextInt();
				int size = 0;
				System.out.print("What size do you want your decal: \n"
						+ "(1. Small, 2.Medium, 3.Large) ");
				size = input.nextInt();
				double decal_price = (size * 0.25) * NumDecal;
				Total_Price += decal_price;
			}
			if (menu == 3) {
				
			}
			}
		}
		System.out.println("Cake Summary:");
		for (int x = 0; x < tiers; x++) {
			System.out.println("Tier " + (x+1) + " Flavor: " + Flavors[x] + ", Icing: " + Icing[x]);
		}
		if (decorations == 1) {
			System.out.println("Lettering: " + lettering + "\n"
					+ "Lettering Instructions: " + Ldescription);
			System.out.println("Decal : " + frostingDecal);
		}		
		System.out.printf("Order Total for %s is: $%5.2f", name, Total_Price);
	
	}
		
}


abstract class Cake {
	private String flavor = " ";
	private String icing = " ";
	
	public Cake() {	
	}
	public Cake(String flavor, String icing) {
		this();
		this.flavor = flavor;
		this.icing = icing;
	}
	public String getFlavor() {
		return flavor;
	}
	public String getIcing() {
		return icing;
	}
	public abstract double getVolume();
	public abstract double getSurfaceArea();
	public abstract double getCircumference();
}
class Cylinder extends Cake {
	private double radius; 
	private double height;

	public Cylinder() {
	}
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
	public double getRadius() {
		return radius;
	}
	public double getHeight() {
		return height;
	}
	public void setRadius() {
		radius = radius;
	}
	public void setHeight() {
		height = height;
	}
	public double getVolume() {
		double base = Math.PI * (radius * radius);
		double volume = base * height;
		return volume;
	}
	public double getCircumference() {
		double Circumference = 2 * Math.PI * radius;
		return Circumference;
	}
	public double getSurfaceArea() {
		double SurfaceArea = (2 * Math.PI * radius * height) +(Math.PI * radius * radius);
		return SurfaceArea;
	}
}
class Rectangle_Prism extends Cake {
	private double length;
	private double width;
	private double height;
	
	public Rectangle_Prism() {
	}
	public Rectangle_Prism(double length, double width, double height) {
		this.length = length;
		this.width = width; 
		this.height = height;
	}
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public void setLength() {
		length = length;
	}
	public void setWidth() {
		width = width;
	}
	public void setHeight() {
		height = height;
	}
	public double getVolume() {
		double volume = length * width * height;
		return volume;
	}
	public double getCircumference() {
		double Circumference = (length * 2) + (width * 2);
		return Circumference;
	}
	public double getSurfaceArea() {
		double SurfaceArea = (length * width) + (height * length * 2) + (height * width * 2);
		return SurfaceArea;
		
	}
}


