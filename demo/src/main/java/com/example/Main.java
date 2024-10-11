package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("server avviato!");

        ServerSocket s1 = new ServerSocket(3000); //La porta puo essere gia aperta quindi va gestita l'eccezione
        Socket s = s1.accept();
        System.out.println("un cliente si e creato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringaRicevuta = in.readLine();
        System.out.println("La stringa ricevuta: " + stringaRicevuta);

        String stringaMaiuscola = stringaRicevuta.toUpperCase();
        out.writeBytes(stringaMaiuscola + '\n');

        s.close();
        s1.close();
    }
}