public class Main {
    public static void main(String[] args) {
        FileStorage localStorage = new LocalFileStorage();
        FileStorage cloudStorage = new CloudFileStorage();

        // Using local file storage
        FileService localFileService = new FileService(localStorage);
        localFileService.uploadFile("document.txt", "This is some text.");
        localFileService.removeFile("document.txt");

        // Using cloud file storage
        FileService cloudFileService = new FileService(cloudStorage);
        cloudFileService.uploadFile("image.jpg", "This is image data.");
        cloudFileService.removeFile("image.jpg");
    }
}