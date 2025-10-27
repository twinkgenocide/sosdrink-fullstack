package cl.duoc.risani.sosdrink.backend.restcontrollers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/img")
public class FotoRestController {

    @Value("${img.path}")
    private String uploadPath;

    @GetMapping("/{nombreArchivo}")
    public ResponseEntity<UrlResource> obtenerImagen(@PathVariable String nombreArchivo) {
        Path path = Paths.get(uploadPath + nombreArchivo);
        if (!Files.exists(path)) {
            return ResponseEntity.notFound().build();
        }

        try {
            UrlResource resource = new UrlResource(path.toUri());
            String contentType = Files.probeContentType(path);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, contentType)
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> subirImagen(@RequestParam("img") MultipartFile img) {
        String contentType = img.getContentType();
        if (!contentType.startsWith("image/")) {
            return ResponseEntity.badRequest().build();
        }

        try {
            String nombreOriginal = img.getOriginalFilename();
            String extension = "";

            if (nombreOriginal != null && nombreOriginal.contains(".")) {
                extension = nombreOriginal.substring(nombreOriginal.lastIndexOf("."));
            }

            String nombreArchivo = UUID.randomUUID() + extension;
            Path path = Paths.get(uploadPath + nombreArchivo);

            Files.createDirectories(path.getParent());
            Files.write(path, img.getBytes());

            return ResponseEntity.ok("/api/img/" + nombreArchivo);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
