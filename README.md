
# BootCampProject

Bu proje, bir eğitim kampı (Bootcamp) yönetim sisteminin temel servislerini içerir. CRUD işlemleri yapılabilir.
## Kullanılan Teknolojiler

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

## Proje Özellikleri

- **Applicant**, **Instructor**, **Employee**, **Application**, **Bootcamp** ve **Blacklist** entity’leri oluşturuldu.
- Service ve Controller katmanları ile CRUD işlemleri sağlandı.
- DTO yapısı kullanılarak veri transferi düzenlendi.
- Temiz kod ve katmanlı mimari prensiplerine uygun geliştirildi.

## Kurulum

1. Projeyi klonlayın:
   ```bash
   git clone https://github.com/mustafatopall/BootCampProject.git
   ```
2. Proje dizinine gidin:
   ```bash
   cd BootCampProject
   ```
3. Gerekli bağlılıkları yüklemek ve projeyi derlemek için:
   ```bash
   mvn clean install
   ```
4. Uygulamayı başlatın:
   ```bash
   mvn spring-boot:run
   ```

## Kullanım

Uygulama başlatıldıktan sonra aşağıdaki gibi API endpointleri kullanabilirsiniz:

- `POST /api/applicants` - Yeni aday oluştur
- `GET /api/applicants/{id}` - Belirli bir adaya eriş
- `PUT /api/applicants/{id}` - Aday bilgilerini güncelle
- `DELETE /api/applicants/{id}` - Adayı sil

Benzer endpointler diğerleri için de geçerlidir.

## Lisans

Bu proje üzerinde şuan belirlenmiş bir lisans bulunmamaktadır.
