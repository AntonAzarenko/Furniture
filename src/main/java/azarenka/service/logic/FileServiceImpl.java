package azarenka.service.logic;

import azarenka.security.service.LoggedUser;
import azarenka.security.service.UserPrinciple;
import azarenka.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private ServletContext context;


    private UserPrinciple userPrinciple;

    @Override
    public void upload(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            String name = file.getOriginalFilename();

            String filePath = context.getRealPath("") + "/resources" + File.separator + "uploads" + File.separator +
                    LoggedUser.safeGet().getUsername() + File.separator + "image";
            Path resourceDirectory = Paths.get(filePath);

                File dir = new File(resourceDirectory + File.separator);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File loadFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile));
                stream.write(bytes);
                stream.flush();
                stream.close();
        } catch (IOException e) {

        }
    }

    @Override
    public void update(MultipartFile file, Long id) {
        remove(id);
        upload(file);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public String getPath(Long id) {
        String path = "resources/uploads/" + LoggedUser.safeGet().getUsername() + "/image/";
        return path;
    }
}
