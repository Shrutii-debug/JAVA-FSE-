
interface Document {
    void open();
    void save();
}

class WordDocument implements Document {
    public void open() { System.out.println("Opening Word document..."); }
    public void save() { System.out.println("Saving Word document as .docx"); }
}

class PdfDocument implements Document {
    public void open() { System.out.println("Opening PDF document..."); }
    public void save() { System.out.println("Saving PDF document as .pdf"); }
}

class ExcelDocument implements Document {
    public void open() { System.out.println("Opening Excel document..."); }
    public void save() { System.out.println("Saving Excel document as .xlsx"); }
}

abstract class DocumentFactory {
    
    public abstract Document createDocument();

    
    public Document openNewDocument() {
        Document doc = createDocument();
        doc.open();
        return doc;
    }
}


class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        System.out.println("--- Creating and using a Word document ---");
        Document doc1 = wordFactory.createDocument();
        doc1.open();
        doc1.save();

        System.out.println("\n--- Creating and using a PDF document ---");
        Document doc2 = pdfFactory.createDocument();
        doc2.open();
        doc2.save();

        System.out.println("\n--- Creating and using an Excel document ---");
        Document doc3 = excelFactory.createDocument();
        doc3.open();
        doc3.save();

        System.out.println("\n--- Using the shared openNewDocument() workflow method ---");
        excelFactory.openNewDocument();
    }
}
