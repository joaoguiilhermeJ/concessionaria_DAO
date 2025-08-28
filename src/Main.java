import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MotoDao motoDao = new MotoDao();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 Cadastrar moto");
            System.out.println("2 Listar motos");
            System.out.println("3 Atualizar preço de moto");
            System.out.println("4 Deletar moto");
            System.out.println("5 Ver preço médio das motos");
            System.out.println("0 Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            if (opcao == 0) {
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();  

                    Moto moto = new Moto(nome, ano, preco);
                    motoDao.inserirMoto(moto);
                    break;

                case 2:
                    List<Moto> motos = motoDao.buscarMotos();
                    if (motos.isEmpty()) {
                        System.out.println("Nenhuma moto cadastrada");
                    } else {
                        for (Moto m : motos) {
                            System.out.println("ID: " + m.getId() + " | Nome: " + m.getNome() + " | Ano: " + m.getAno() + " | Preço: R$ " + m.getPreco());
                        }
                    }
                    break;

                case 3:
                    System.out.print("ID da moto: ");
                    int id = scanner.nextInt();
                    System.out.print("Novo preço: ");
                    double novoPreco = scanner.nextDouble();
                    motoDao.atualizarPrecoMoto(id, novoPreco);
                    break;

                case 4:
                    System.out.print("ID da moto: ");
                    int idDeletar = scanner.nextInt();
                    motoDao.deletarMoto(idDeletar);
                    break;

                case 5:
                    double precoMedio = motoDao.calcularPrecoMedio();
                    System.out.println("Preço médio das motos: R$ " + precoMedio);
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
