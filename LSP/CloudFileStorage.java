// Concrete class for Cloud Storage (e.g., AWS S3)
class CloudFileStorage extends FileStorage {
    private java.util.HashMap<String, String> cloudStorage = new java.util.HashMap<>();

    @Override
    public void saveFile(String fileName, String data) {
        cloudStorage.put(fileName, data);
        System.out.println("File \"" + fileName + "\" saved in cloud storage.");
    }

    @Override
    public void deleteFile(String fileName) {
        cloudStorage.remove(fileName);
        System.out.println("File \"" + fileName + "\" deleted from cloud storage.");
    }
}
