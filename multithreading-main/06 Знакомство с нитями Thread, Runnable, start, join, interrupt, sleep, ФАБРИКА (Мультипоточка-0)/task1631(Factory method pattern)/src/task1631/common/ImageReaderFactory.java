package task1631.common;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) throws IllegalArgumentException{
        if (imageTypes == null) throw new IllegalArgumentException("Неизвестный тип картинки");
        switch ( imageTypes ) {
            case BMP: return new BmpReader();
            case JPG: return new JpgReader();
            case PNG: return new PngReader();
            default: throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
