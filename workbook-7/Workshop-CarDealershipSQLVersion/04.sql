SELECT * FROM dealerships 
WHERE dealership_id = (SELECT dealership_id 
							FROM inventory 
								WHERE VIN = '1A2B3C4D5E6F7G8H9I0J');  