package network
import model.Barang
import retrofit2.http.GET


interface ApiService {
    @GET("daftar_barang.json")
    suspend fun getBarang(): List<Barang>
}