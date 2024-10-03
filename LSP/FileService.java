// Client class that uses FileStorage
class FileService {
    private FileStorage storage;

    public FileService(FileStorage storage) {
        this.storage = storage;
    }

    public void uploadFile(String fileName, String data) {
        storage.saveFile(fileName, data);
    }

    public void removeFile(String fileName) {
        storage.deleteFile(fileName);
    }
}
