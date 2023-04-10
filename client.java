package tp02Res;
import java.io.*;
import java.net.*;


public class client {
	public static void main(String[] args) {
        try {
//creation_socket_contient_adress_et_num_port
            Socket socket = new Socket("localhost", 8099);
            System.out.println("Connecté au serveur .. ");

            System.out.println("Address : " + socket.getInetAddress().getHostAddress());
//creation_des_flux
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
//creation_matrice1_et_2
            double[][] matrice1 = {{1, 3, 5}, {6, 8, 9}};
            double[][] matrice2 = {{7, 8}, {10, 11}, {12, 13}};
           
            out.writeObject(matrice1);
            out.writeObject(matrice2);

            double[][] resultat = (double[][]) in.readObject();

            System.out.println("Résultat :");
            for (int i = 0; i < resultat.length; i++) {
                for (int j = 0; j < resultat[0].length; j++) {
                    System.out.print(resultat[i][j] + " ");
                }
                System.out.println();
            }

            out.close();
            in.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


             
