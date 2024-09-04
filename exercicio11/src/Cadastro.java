import java.util.*;

public class Cadastro {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Digite os nomes e sexos");
        System.out.println("(Formato: 'João','M';'Maria','F'; não deve conter espaço durante a digitação dos cadastros e após informar o sexo por o ';' ");
        String i = sc.nextLine();


        String[] entradas = i.split(";");


        List<String> nomes = new ArrayList<>();
        Map<String, List<String>> porGenero = new HashMap<>();
        porGenero.put("Masculino", new ArrayList<>());
        porGenero.put("Feminino", new ArrayList<>());


        for (String entrada : entradas) {
            String[] partes = entrada.split(",");
            if (partes.length == 2) {
                String nome = partes[0].trim();
                String sexo = partes[1].trim();


                nomes.add(nome);


                if (sexo.equalsIgnoreCase("M")) {
                    porGenero.get("Masculino").add(nome);
                } else if (sexo.equalsIgnoreCase("F")) {
                    porGenero.get("Feminino").add(nome);
                } else {
                    System.out.println("Sexo inválido para o nome: " + nome);
                }
            } else {
                System.out.println("Entrada inválida: " + entrada);
            }
        }

        Collections.sort(nomes);

        porGenero.get("Masculino").sort(Comparator.naturalOrder());
        porGenero.get("Feminino").sort(Comparator.naturalOrder());


        System.out.println("Nomes ordenados:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        System.out.println();
        System.out.println("Nomes por gênero:");
        System.out.println("Masculino:");
        for (String nome : porGenero.get("Masculino")) {
            System.out.println(nome);
        }

        System.out.println();
        System.out.println("Feminino:");
        for (String nome : porGenero.get("Feminino")) {
            System.out.println(nome);
        }

        sc.close();
    }
}
