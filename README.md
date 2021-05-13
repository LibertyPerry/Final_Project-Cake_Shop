# Final_Project-Cake_Shop

## Synopsis
This is a program that is disigned for a cake shop. The customer can simply run the code and decide what they want for there cake. (ex Number of tiers, Flavor of cake, Icing type and color, decorations, and lettering)

## Motivation
I build this so that I was an easy way for a customer to input what they want and get a price for what they want. 

## How to run
Only the Cake_Shop file is needed to run the program. 

![Screen Shot 2021-05-13 at 8 08 40 AM](https://user-images.githubusercontent.com/77160908/118137461-76050580-b3c2-11eb-8b49-3ed8aef6a990.png)
[This is and example of the code running]

## Code Example
I am proud of this snippet of code because I can able to create two different objects with an if statement. 
 '''
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
 '''
 ## Tests
 how to run the tests with code examples
 
 ## Contributors
 
