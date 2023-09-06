package kz.mun.securityjwt.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
    @Value("${app.minio.url}")
    private String minioURL;

    @Value("${app.minio.port}")
    private int minioPort;

    @Value("${app.minio.access-key}")
    private String minioAccessKey;

    @Value("${app.minio.secret-key}")
    private String minioSecretKey;

    @Value("${app.minio.secure}")
    private boolean minioSecure;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minioURL, minioPort, minioSecure)
                .credentials(minioAccessKey, minioSecretKey)
                .build();
    }
}
