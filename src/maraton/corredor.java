package maraton;
import java.lang.Thread;
import javax.swing.JProgressBar;

public class corredor extends Thread{

	public String nombre;
	public int nPartipante;
	int tiempo;
	int velocidad;
	int proporcion;
	int descanso;
	int salud;
	public String nivel;
       
	JProgressBar jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9,jp10;
	
	public corredor(String n, int nPar, int valor, JProgressBar  f) {
         this.jp1 = f;this.jp2 = f;this.jp3 = f;this.jp4 = f;
          this.jp5 = f;this.jp6 = f;this.jp7 = f;this.jp8 = f;
           this.jp9 = f;this.jp10 = f;
		this.nombre = n;
		this.nPartipante = nPar;
		if(valor == 1) {
			this.nivel = "Profesional";
			this.velocidad = 240;
			this.tiempo = 300;
		}else if(valor == 2) {
			this.nivel = "Maestro";
			this.velocidad = 200;
			this.tiempo = 350;
		}else if(valor == 3) {
			this.nivel = "Experto";
			this.velocidad = 160;
			this.tiempo = 400;
	    }else {
			this.nivel = "Principiante";
			this.velocidad = 120;
			this.tiempo=450;
		}
                
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getParticipante() {
		return this.nPartipante;
	}
	public String getNivel() {
		return this.nivel;
	}
	
	public void run() {
		System.out.println("El corredor n° " + getParticipante() + " " + getNombre() +" con nivel " + getNivel() +" ha iniciado la carrera. \n" );
                
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=1;i<10;i++) {
			System.out.println("El corredor n° " + getParticipante() + " " + getNombre() +" con nivel " + getNivel() +" ha llegado al km " + i + "\n");
			llenarBar(getParticipante(), i);
			if(i%3==0) {
				recuperar(i);
				try {
					sleep(descanso);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
			
				this.salud = (int) (Math.random() * 100 + 1);
			
				if(this.salud < 51) {
					System.out.println("El corredor n° " + getParticipante() + " " + getNombre() +" con nivel " + getNivel() +" sigue en forma en el km " + i + "\n");
				}else if(this.salud < 81){
					if(this.velocidad/2 > 0) {
						this.velocidad/=2;
						this.tiempo*=2;
						System.out.println("El corredor n° " + getParticipante() + " " + getNombre() +" con nivel " + getNivel() +" ha tenido una lesion en el km " + i + "\n");
                                               llenarBar(getParticipante(), i);
					}else {
						ranking.vivo[this.nPartipante-1] = false;
						ranking.rank[ranking.fin] = this.nPartipante;
						ranking.nombre[ranking.fin] = this.nombre;
						ranking.nivel[ranking.fin] = this.nivel;
						ranking.fin--;
						ranking.miembros++;
						System.out.println("El corredor n° " + getParticipante() + " " + getNombre() +" con nivel " + getNivel() +" ha abandonado la carrera en el km " + i + "\n");
						llenarBar(getParticipante(), i);
                                                return;
					}
				}else if(this.salud < 96) {
					if(this.velocidad-10 > 0) {
						this.proporcion = this.velocidad / 10;
						this.velocidad-=10;
						this.tiempo+=(this.tiempo/this.proporcion);
						System.out.println("El corredor n° " + getParticipante() + " " + getNombre() +" con nivel " + getNivel() +" se ha cansado en el km " + i + "\n");
                                               llenarBar(getParticipante(), i);
					}else {
						ranking.vivo[this.nPartipante-1] = false;
						ranking.rank[ranking.fin] = this.nPartipante;
						ranking.nombre[ranking.fin] = this.nombre;
						ranking.nivel[ranking.fin] = this.nivel;
						ranking.fin--;
						ranking.miembros++;
						System.out.println("El corredor n° " + getParticipante() + " " + getNombre() +" con nivel " + getNivel() +" ha abandonado la carrera en el km " + i + "\n");
                                               llenarBar(getParticipante(), i);
						return;
					}
				}else {
					ranking.vivo[this.nPartipante-1] = false;
					ranking.rank[ranking.fin] = this.nPartipante;
					ranking.nombre[ranking.fin] = this.nombre;
					ranking.nivel[ranking.fin] = this.nivel;
					ranking.fin--;
					ranking.miembros++;
					System.out.println("El corredor n° " + getParticipante() + " " + getNombre() +" con nivel " + getNivel() +" ha abandonado la carrera en el km " + i + "\n");
                                       llenarBar(getParticipante(), i);
					return;
				}
			}
			try {
				sleep(this.tiempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("El corredor n° " + getParticipante() + " " + getNombre() +" con nivel " + getNivel() +" ha terminado la carrera. \n");
	}
	public void recuperar(int i)
	{
		this.descanso= (int) (Math.random() * 2000);
		if(this.descanso < 100) {
			System.out.println("El corredor n° " + getParticipante() + " " + getNombre() +" con nivel " + getNivel() +" no ha descansado en el km " + i + "\n");
		}else {							
			this.tiempo-=(descanso/200);
			this.velocidad+=(descanso/100);
			System.out.println("El corredor n° " + getParticipante() + " " + getNombre() +" con nivel " + getNivel() +" va a descansar "+ this.descanso + " ms en el km " + i + "\n"
					+ "¡Va a recuperar "+ this.descanso/100 + " de velocidad! \n");
		}
	}
        
        public void llenarBar(int part, int value){
      
        
        switch(part){
            case 1:
                jp1.setValue(value);
                
                jp1.setString("KM: " + value);
                
                break;
                case 2:
                    jp2.setValue(value);
                    jp2.setString("KM: " + value);
                break;
                case 3:
                   jp3.setValue(value);
                   jp3.setString("KM: " + value);
                break;
                case 4:
                    jp4.setValue(value);
                    jp4.setString("KM: " + value);
                break;
                case 5:
                   jp5.setValue(value);
                   jp5.setString("KM: " + value);
                break;
                case 6:
                    jp6.setValue(value);
                    jp6.setString("KM: " + value);
                break;
                case 7:
                  jp7.setValue(value);
                  jp7.setString("KM: " + value);
                break;
                case 8:
                   jp8.setValue(value);
                   jp8.setString("KM: " + value);
                break;
                case 9:
                    jp9.setValue(value);
                    jp9.setString("KM: " + value);
                break;
                case 10:
                    jp10.setValue(value);
                    jp10.setString("KM: " + value);
                break;
                
                
        }
        
        }
}
