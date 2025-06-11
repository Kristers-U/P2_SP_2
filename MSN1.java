package pack;
import java.util.Scanner;

public class MSN1 {
	//noapaļošanas funkcija
	public static float round(double value) {
	    return (float) (Math.round(value * 10000) / 10000.0);// Noapaļo skaitli līdz 4 cipariem aiz komata
	}
	//2d masīvu kopešanas funkcija
	public static float[][] deepCopy(float[][] array) {
	    if (array == null) return null;

	    float[][] copy = new float[array.length][]; //jauns outer array
	    for (int i = 0; i < array.length; i++) {
	        copy[i] = array[i].clone(); //katra inner array kopija
	    }
	    return copy;
	}

	
	//sistēmas izvades funkcija
	public static void loop(float array[][], float k1, int step) {
		if (step<=0) { //ja nav pirma reize izvadei tad izlaiž rindu
			System.out.println();
		}
	    for (int i = 0; i < array.length; i++) {
	        System.out.print("Rinda " + (i+1) + ": ");
	        
	        for (int j = 0; j < array[i].length; j++) {
	            float value = array[i][j];
	            switch(j) {
	        	  case 0:
	        		  if (step<=0) { //ja pirmo reizi izvada
	        			  switch(i) {
	        			  	case 0:
	        			  		System.out.print("/"+value+"x");
	        			  		break;
	        			  	case 1:
	        			  		System.out.print("{"+value+"x");
	        			  		break;
	        			  	case 2:
	        			  		System.out.print("\\"+value+"x");
	        			  		break;
	        			      }
	        		  }  else { //ja izvade jau tikta veikta pirms sistēmas ir "=>"
	        			  switch(i) {
	        			  	case 0:
	        			  		System.out.print("   /"+value+"x");
	        			  		break;
	        			  	case 1:
	        			  		System.out.print("=> {"+value+"x");
	        			  		break;
	        			  	case 2:
	        			  		System.out.print("   \\"+value+"x");
	        			  		break;
	        			      }
	        		  }
	        		  break;
	        	  case 1:
	        		  if (value<0) {
	        			  System.out.print(value+"y");
	        		  } else {
	        			  System.out.print("+"+value+"y");
	        		  }
	        		  break;
	        	  case 2:
	        		  if (value<0) {
	        			  System.out.print(value+"z");
	        		  } else {
	        			  System.out.print("+"+value+"z");
	        		  }
	        		  break;
	        	  case 3:
	        		  
	        		  if (i==1) {
	        			  System.out.print("="+value+"    =>");
	        		  } else {
	        			  System.out.print("="+value);
	        		  }
	        		  if (step==-1 && i==0) {
	        			  System.out.print("|:"+k1);
	        		  } 
	        		  if (step==2 && i==1) {
	        			  System.out.print("|:"+k1);
	        		  }
	        		  break;
	        	}
	        }
	        System.out.println();
	    }
	}
	//komentāru izvades funkcija
	public static void komentars (float array[][], float k1, int state) {
	    if (state == 1) { 
	        // Lielais komentārs (big comment)
	        for (int x = 0; x < 2; x++) {
	            k1 = array[x + 1][0] * -1;
	            System.out.print("\nRinda 0: |" + k1 + "R1+R" + (x + 2) + ": |"); 
	            // Output each row after transformation
	            System.out.println();
	            for (int i = 0; i < array.length; i++) {
	                System.out.print("Rinda " + (i + 1) + ": ");
	                for (int j = 0; j < array[i].length; j++) {
	                	float value=0;
	                	if (i==0) {
	                		value = round(array[i][j]*k1);
	                	} else {
	                		value = array[i][j];
	                	}
	                    
	                    float result = round(array[0][j] * k1 + array[x + 1][j]); // elementu summma R1 + R2
	                    switch (j) {
	                        case 0:
	                        	if (x==1 && i==1) {
	                        		System.out.print("|"+array[2][j]+"x");
	                        	} else if (i == 2) {
	                                System.out.print("|" + result + "x");
	                            } else {
	                                System.out.print("|" + value + "x");
	                            }
	                            
	                            break;
	                        case 1:
	                        	if (x==1 && i==1) {
	                        		if (array[2][j]<0) {
	                        			System.out.print(array[2][j]);
	                        		} else {
	                        			System.out.print("+"+array[2][j]);
	                        		}
	                        	} else if (i == 2) {
	                                if (result < 0) {
	                                    System.out.print(result + "y");
	                                } else {
	                                    System.out.print("+" + result + "y");
	                                }
	                            } else {
	                                if (value < 0) {
	                                    System.out.print(value + "y");
	                                } else {
	                                    System.out.print("+" + value + "y");
	                                }
	                            }
	                            
	                            break;
	                        case 2:
	                        	if (x==1 && i==1) {
	                        		if (array[2][j]<0) {
	                        			System.out.print(array[2][j]);
	                        		} else {
	                        			System.out.print("+"+array[2][j]);
	                        		}
	                        	} else if (i == 2) {
	                                if (result < 0) {
	                                    System.out.print(result + "z");
	                                } else {
	                                    System.out.print("+" + result + "z");
	                                }
	                            } else {
	                                if (value < 0) {
	                                    System.out.print(value + "z");
	                                } else {
	                                    System.out.print("+" + value + "z");
	                                }
	                            }
	                            break;
	                        case 3:
	                            switch (i) {
	                                case 0:
	                                    System.out.print("=" + value + "|");
	                                    break;
	                                case 1:
	                                	if (x==1 && i==1) {
	    	                        			System.out.print("="+array[2][j]+"|    =>");
	    	                        	} else {
	    	                        		System.out.print("=" + value + "|    =>");
	    	                        	}
	                                    
	                                    break;
	                                case 2:
	                                    System.out.print("=" + result + "|");
	                                    break;
	                            }
	                            break;
	                    }
	                }
	                System.out.println();
	            }
	        }
	    } else { 
	        // Mazais komentārs
	        System.out.println("\nRinda 0: |" + k1 + "R2+R3: "+"|");
	        for (int i = 0; i < array.length; i++) {
	            System.out.print("Rinda " + (i + 1) + ": ");
	            for (int j = 0; j < (array[i].length); j++) {
	            	int y=0;
	            	if (i==2) {
	            		y=i;
	            	} else {
	            		y=i+1;
	            	}
	            	
	                float value = array[y][j];
	                float result = array[1][j] + array[2][j];
	                result=round(result);
	                //array[1][j] = result;
	                switch (j) {
	                    case 0:
	                        if (i == 2) {
	                            System.out.print("|" + result + "x");
	                        } else {
	                            System.out.print("|" + value + "x");
	                        }
	                        break;
	                    case 1:
	                        if (i == 2) {
	                            if (result < 0) {
	                                System.out.print(result + "y");
	                            } else {
	                                System.out.print("+" + result + "y");
	                            }
	                        } else {
	                            if (value < 0) {
	                                System.out.print(value + "y");
	                            } else {
	                                System.out.print("+" + value + "y");
	                            }
	                        }
	                        break;
	                    case 2:
	                        if (i == 2) {
	                            if (result < 0) {
	                                System.out.print(result + "z");
	                            } else {
	                                System.out.print("+" + result + "z");
	                            }
	                        } else {
	                            if (value < 0) {
	                                System.out.print(value + "z");
	                            } else {
	                                System.out.print("+" + value + "z");
	                            }
	                        }
	                        break;
	                    case 3:
	                        switch (i) {
	                            case 0:
	                                System.out.print("=" + value + "|");
	                                break;
	                            case 1:
	                                System.out.print("=" + value + "|    =>");
	                                break;
	                            case 2:
	                                System.out.print("=" + result + "|");
	                                break;
	                        }
	                        break;
	                }
	            }
	            System.out.println();
	        }
	    }
	}



	//Gausa metodes aprēķins
	public static void gauss(float array[][]) {
		int solis=0;//sistēmas izvades papildnosacījums
		float temp=0;//vērtība reizinātāju saglabāšanai
		float k1=0;//papildus vērtība reizinātāja saglabāšanai
		int state=1;//komentāra saskaitīšanu skaits
		float[][] copy=deepCopy(array);
		if (array[0][0]!=1) {//ja x1 nav vienāds ar 0
			temp=array[0][0];
			solis=-1;
			loop(array, temp, solis);//izvade
			System.out.println();//atstarpe
			solis=1;
			for (int j=0; j<4;j++) {
				array[0][j]/=temp;
				array[0][j]=round(array[0][j]);
			}
		}
		loop(array, temp, solis);//izvade
		komentars(array, k1, state);//komentārs(lielais)
		state++;// komentāra režīma maiņa no lielā uz mazo
		temp=array[1][0]*-1;//vajag izmantot temp, jo ja ciklā temp(mainīgā) vietā būs tā vērtība nekas nestrādās
		for (int j=0; j<4; j++) {
			array[1][j]=(array[0][j]*temp)+array[1][j];
			array[1][j]=round(array[1][j]);
		}
		temp=array[2][0]*-1;//vajag izmantot temp, jo ja ciklā temp(mainīgā) vietā būs tā vērtība nekas nestrādās
		for (int j=0; j<4; j++) {
			array[2][j]=(array[0][j]*temp)+array[2][j];
			array[2][j]=round(array[2][j]);
		}
		System.out.println();//atstarpe
		solis++;//izvade ar "|:x"
		temp=array[1][1];
		loop(array, temp, solis);//izvade
		solis--;//izvade bez "|:x"
		for (int j=0; j<4; j++) {
			array[1][j]=array[1][j]/temp;
			array[1][j]=round(array[1][j]);
		}
		System.out.println();//atstarpe
		loop(array, temp, solis);//izvade
		float[] arr_copy; //1d masīva kopijas deklarēšana
		arr_copy= new float[4];//1d masīva kopijas inicializācija
		temp=array[2][1]*-1;
		for (int j=0; j<4; j++) {//-0,1068R2
			arr_copy[j]=array[1][j];//1R2 kopija!
			array[1][j]=array[1][j]*temp;
			array[1][j]=round(array[1][j]);
		}
		System.out.println();//atstarpe	
		komentars(array, temp, state);//otrais komentārs
		for (int j=0; j<4; j++) {//-0,1068R2+R3
			array[2][j]=array[1][j]+array[2][j];
			array[2][j]=round(array[2][j]);
			array[1][j]=arr_copy[j];
		}
		System.out.println();//atstarpe
		loop(array, temp, solis);//izvade
		temp=array[2][2];
		for (int j=0; j<4; j++) {
			array[2][j]=array[2][j]/temp;
			array[2][j]=round(array[2][j]);
		}
		float z=array[2][3];//koeficients z
		System.out.println("\nkoeficienta z aprēķināšana");
		loop(array, temp, solis);//izvade
		array[1][3]=array[1][3]+(array[1][2]*-z);//b2=b2+z2*-z
		array[1][2]=0;//z2=0 jo tas tika pārbīdīts pa labi
		for (int j=0; j<4; j++) {
			array[1][j]=round(array[1][j]);
		}
		float y=array[1][3];//y koeficients
		System.out.println("\nkoeficienta y aprēķināšana");
		loop(array, temp, solis);//izvade
		array[0][3]=array[0][3]+array[0][1]*-y+array[0][2]*-z;
		array[0][3]=round(array[0][3]);
		float x=array[0][3];//x koeficients
		array[0][1]=0;
		array[0][2]=0;
		System.out.println("\nkoeficienta x aprēķināšana");
		loop(array, temp, solis);//izvade
		System.out.println("\nRinda 1: /x="+x);
		System.out.println("Rinda 2: {y="+y);
		System.out.println("Rinda 3: \\z="+z);
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<array[i].length; j++) {
				switch (j) {
					case 0:
						copy[i][j]=copy[i][j]*x;
						copy[i][0]=round(copy[i][0]);
						break;
					case 1:
						copy[i][j]=copy[i][j]*y;
						copy[i][1]=round(copy[i][1]);
						break;
					case 2:
						copy[i][2]=copy[i][2]*z;
						copy[i][2]=round(copy[i][2]);
						break;
				}
			}
		}
		System.out.println("\nPārbaude ievietojot x,y,z vērtības");
		state=0;
		loop(copy, temp, solis);
		for (int i=0; i<copy.length; i++) {
			copy[i][2]=copy[i][0]+copy[i][1]+copy[i][2];
			copy[i][2]=round(copy[i][2]);
		}
		float R1_result=copy[0][2];
		float R2_result=copy[1][2];
		float R3_result=copy[2][2];
		System.out.println("\nRinda 1: /"+R1_result+"="+copy[0][3]);
		System.out.println("Rinda 2: {"+R2_result+"="+copy[1][3]);
		System.out.println("Rinda 3: \\"+R3_result+"="+copy[2][3]);
		System.out.println("\nAtbilde: ("+x+";"+y+";"+z+")");
	}
	
	public static void main(String[] args) {
		try {
			Scanner input= new Scanner(System.in);
			
			System.out.println("(1) Piemērs;\n(2) Pašam ievadīt sistēmu(3. vienādojumi 3. mainīgie + brīvais loceklis);\nIzvēlies opciju: ");
			int opcija=input.nextInt();
			
			if (opcija==1) {
				float[][] array; //masīva deklarēšana
				array= new float[3][4];//masīva inicializācija
				//masīva vērtības
				array[0][0]=(float) 1.60;
				array[0][1]=(float) 2.18;
				array[0][2]=(float) -0.72;
				array[0][3]=(float) 1.15;
				array[1][0]=(float) 0.43;
				array[1][1]=(float) -0.16;
				array[1][2]=(float) 0.53;
				array[1][3]=(float) 0.83;
				array[2][0]=(float) 0.34;
				array[2][1]=(float) 0.57;
				array[2][2]=(float) -0.83;
				array[2][3]=(float) -0.42;
				gauss(array);
			} else if (opcija==2) {//Lietotāja ievades opcija
				int i=3;
				int j=4;
				float[][] array; //masīva deklarēšana
				array= new float[i][j];//masīva inicializācija
				//masīva aizpildīšana
				int v_jums=1;
				int mainigais=1;
				for (int n=0; i*j>n; n++) {//masīva aizpildīšana
					if (mainigais==4) {
						System.out.println("Ievadi "+v_jums+". vienādojuma brīvo locekli: ");
					} else {
						System.out.println("Ievadi "+v_jums+". vienādojuma "+mainigais+". mainīgo: ");
					}
				    array[v_jums-1][mainigais-1]=input.nextFloat();
				    if (mainigais<j) {
				        mainigais++;
				    } else if (mainigais==j) {
				        mainigais=1;
				        v_jums++;
				    }
				}
				gauss(array);
			} else {
				System.out.println("Tādas opcijas nav!");
			}
			
			
			input.close();
		} catch (Exception e) {
			System.out.println("Kļūda!");
		}
	}
}