
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Main {
    public static void main(String[] args) {
        Cartaz cartazSuper = new Cartaz("Meu cartaz Super", "A3", "Super");
        cartazSuper.definirPreco(19.99);
        // System.out.println("O preço do cartaz '" + cartazSuper.getTitulo() + "'
        // (tamanho " + cartazSuper.getTamanho()
        // + ", tipo " + cartazSuper.getTipo() + ") é: " + cartazSuper.obterPreco());

        Cartaz cartazAtacado = new Cartaz("Meu cartaz Atacado", "A4", "Atacado");
        cartazAtacado.definirPreco(9.99);
        // System.out
        // .println("O preço do cartaz '" + cartazAtacado.getTitulo() + "' (tamanho " +
        // cartazAtacado.getTamanho()
        // + ", tipo " + cartazAtacado.getTipo() + ") é: " +
        // cartazAtacado.obterPreco());

        Cartaz cartazHiper = new Cartaz("Meu cartaz Hiper", "A5", "Hiper");
        cartazHiper.definirPreco(4.99);
        // System.out.println("O preço do cartaz '" + cartazHiper.getTitulo() + "'
        // (tamanho " + cartazHiper.getTamanho()
        // + ", tipo " + cartazHiper.getTipo() + ") é: " + cartazHiper.obterPreco());

        gerarPDF(cartazSuper, "cartaz/cartaz_super.pdf");
        gerarPDF(cartazAtacado, "cartaz/cartaz_atacado.pdf");
        gerarPDF(cartazHiper, "cartaz/cartaz_hiper.pdf");
    }

    public static void gerarPDF(Cartaz cartaz, String caminhoArquivo) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();

            // Adicionar conteúdo ao documento PDF
            Paragraph titulo = new Paragraph(cartaz.getTitulo(), new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
            Paragraph tamanho = new Paragraph("Tamanho: " + cartaz.getTamanho(),
                    new Font(Font.FontFamily.HELVETICA, 12));
            Paragraph tipo = new Paragraph("Tipo: " + cartaz.getTipo(), new Font(Font.FontFamily.HELVETICA, 12));
            Paragraph preco = new Paragraph("Preço: R$ " + cartaz.obterPreco(),
                    new Font(Font.FontFamily.HELVETICA, 12));

            document.add(titulo);
            document.add(tamanho);
            document.add(tipo);
            document.add(preco);

            document.close();

            System.out.println("PDF gerado com sucesso: " + caminhoArquivo);
        } catch (DocumentException | IOException e) {
            System.err.println("Erro ao gerar o PDF: " + e.getMessage());
        }
    }
}
