package azarenka.service.logic;

import azarenka.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {

    public final static Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    private ServletContext context;

    @Override
    public void upload(MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();
        String name = file.getOriginalFilename();
        File dir = getPath(name);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File loadFile = new File(dir.getAbsolutePath() + File.separator + name);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile));
        stream.write(bytes);
        stream.flush();
        stream.close();
    }

    @Override
    public void update(MultipartFile file, Long id) throws Exception {
        remove(id);
        upload(file);
    }

    @Override
    public void remove(Long id) {
    }

    @Override
    public Resource loadFile(String filename) {
        String filePath = context.getRealPath("") + "/resources" + File.separator + "uploads" + File.separator +
                "handle" + File.separator + "image";
        Path resourceDirectory = Paths.get(filePath);
        try {
            Path file = resourceDirectory.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    @Override
    public void abort(String name) {
        File file = getPath(name);
        File loadFile = new File(file.getAbsolutePath() + File.separator + name);
        loadFile.delete();
    }

    @Override
    public File getPath(String name) {
        String filePath = context.getRealPath("") + "/resources" + File.separator + "uploads" + File.separator +
                "handle" + File.separator + "image";

        Path resourceDirectory = Paths.get(filePath);
        File dir = new File(resourceDirectory + File.separator);

        String filePath2 = "c:/pictures/";
        Path resourceDirectory2 = Paths.get(filePath2);
        File dir2 = new File(resourceDirectory2 + File.separator);

        return dir2;
    }
}
