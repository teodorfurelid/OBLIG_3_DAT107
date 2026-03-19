package directory;

public class Main {
    public static void main(String[] args) {

        AnsattDAO ansattDAO = new AnsattDAO();

        System.out.println("Kobler til databasen...\n");

        //a) Søke opp vitnemålet til en gitt student.
        Ansatt ast = ansattDAO.hentUtAnsatte(1);
        System.out.println(ast);
        System.out.println();

    }

}
