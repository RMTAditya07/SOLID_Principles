// Concrete class for Local File Storage
class LocalFileStorage extends FileStorage {
    private java.util.HashMap<String, String> fileSystem = new java.util.HashMap<>();

    @Override
    public void saveFile(String fileName, String data) {
        fileSystem.put(fileName, data);
        System.out.println("File \"" + fileName + "\" saved locally.");
    }

    @Override
    public void deleteFile(String fileName) {
        fileSystem.remove(fileName);
        System.out.println("File \"" + fileName + "\" deleted from local storage.");
    }
}
