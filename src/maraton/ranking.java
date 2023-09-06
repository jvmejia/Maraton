package maraton;
import java.lang.Thread;


public class ranking extends Thread{

	corredor t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	StringBuffer sb;
	public static int[] rank = new int[10];
	public static String[] nombre = new String[10];
	public static String[] nivel = new String[10];
	public static boolean[] vivo = {true,true,true,true,true,true,true,true,true,true};
	
	int parti;
	public static int fin=9;
	public static int miembros;
	public ranking(corredor h1, corredor h2, corredor h3, corredor h4, corredor h5, corredor h6, corredor h7, corredor h8, corredor h9, corredor h10) {
	
		this.t1 = h1;
		this.t2 = h2;
		this.t3 = h3;
		this.t4 = h4;
		this.t5 = h5;
		this.t6 = h6;
		this.t7 = h7;
		this.t8 = h8;
		this.t9 = h9;
		this.t10 = h10;
		
	}
	
	public void run() {
            sb=new StringBuffer();
		do {
			if(vivo[0]) {
				if(!t1.isAlive()) {
					vivo[0] = false;
					rank[parti] = t1.nPartipante;
					nombre[parti] = t1.nombre;
					nivel[parti] = t1.nivel;
					parti++;
					miembros++;
				}
			}
			if(vivo[1]) {
				if(!t2.isAlive()) {
					vivo[1] = false;
					rank[parti] = t2.nPartipante;
					nombre[parti] = t2.nombre;
					nivel[parti] = t2.nivel;
					parti++;
					miembros++;
				}
			}
			if(vivo[2]) {
				if(!t3.isAlive()) {
					vivo[2] = false;
					rank[parti] = t3.nPartipante;
					nombre[parti] = t3.nombre;
					nivel[parti] = t3.nivel;
					parti++;
					miembros++;
				}
			}
			if(vivo[3]) {
				if(!t4.isAlive()) {
					vivo[3] = false;
					rank[parti] = t4.nPartipante;
					nombre[parti] = t4.nombre;
					nivel[parti] = t4.nivel;
					parti++;
					miembros++;
				}
			}
			if(vivo[4]) {
				if(!t5.isAlive()) {
					vivo[4] = false;
					rank[parti] = t5.nPartipante;
					nombre[parti] = t5.nombre;
					nivel[parti] = t5.nivel;
					parti++;
					miembros++;
				}
			}
			if(vivo[5]) {
				if(!t6.isAlive()) {
					vivo[5] = false;
					rank[parti] = t6.nPartipante;
					nombre[parti] = t6.nombre;
					nivel[parti] = t6.nivel;
					parti++;
					miembros++;
				}
			}
			if(vivo[6]) {
				if(!t7.isAlive()) {
					vivo[6] = false;
					rank[parti] = t7.nPartipante;
					nombre[parti] = t7.nombre;
					nivel[parti] = t7.nivel;
					parti++;
					miembros++;
				}
			}
			if(vivo[7]) {
				if(!t8.isAlive()) {
					vivo[7] = false;
					rank[parti] = t8.nPartipante;
					nombre[parti] = t8.nombre;
					nivel[parti] = t8.nivel;
					parti++;
					miembros++;
				}
			}
			if(vivo[8]) {
				if(!t9.isAlive()) {
					vivo[8] = false;
					rank[parti] = t9.nPartipante;
					nombre[parti] = t9.nombre;
					nivel[parti] = t9.nivel;
					parti++;
					miembros++;
				}
			}
			if(vivo[9]) {
				if(!t10.isAlive()) {
					vivo[9] = false;
					rank[parti] = t10.nPartipante;
					nombre[parti] = t10.nombre;
					nivel[parti] = t10.nivel;
					parti++;
					miembros++;
				}
			}
		}while(this.miembros<10);
		
		System.out.println("\n \n ====================");
                sb.append("====================\n");
		System.out.println("    TOP GANADORES");
                 sb.append("    TOP GANADORES\n");
		System.out.println("====================\n");
                 sb.append("====================\n");
		for(int i=0;i<parti;i++) {
			System.out.println(i+1 + ".- Participante N° " + rank[i] + " " + nombre[i] + " nivel " + nivel[i]) ;
                      sb.append(i+1 + ".- Participante N° " + rank[i] + " " + nombre[i] + " nivel " + nivel[i]+"\n");
		}
		for(int i=parti;i<10;i++) {
			System.out.println("DESCALIFICADO Participante N° " + rank[i] + " " + nombre[i] + " nivel " + nivel[i]) ;
                        sb.append("DESCALIFICADO Participante N° " + rank[i] + " " + nombre[i] + " nivel " + nivel[i]+"\n");
		}
                vtnCorredor.lblResultado.setText(sb.toString());
	}
}
