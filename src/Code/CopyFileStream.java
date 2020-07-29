
package Code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CopyFileStream {
    
    String destiny;
    File dest;
    public CopyFileStream(String source, String destiny) throws IOException {
        
        File source1 = new File(source);
        this.dest = new File(destiny);
        this.destiny = destiny;
        Files.copy(source1.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    
    public String getFilename() {
        return dest.getName();
    }
    
    public String getCanonicalPath() throws IOException {
        return dest.getCanonicalPath();
    }
    
    public String getAbsolutePath() throws IOException {
        return dest.getAbsolutePath();
    }
    
    public boolean exists(){
        File aux = new File(destiny);
        return aux.exists();
    }
}
