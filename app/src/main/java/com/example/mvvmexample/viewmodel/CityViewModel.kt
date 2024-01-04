import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.model.City
import com.example.mvvmexample.model.CityDataProvider

class CityViewModel : ViewModel() {

    private val cityData = MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()
    private var currentCityIndex = 0
    private val delay = 2000L

    private val handler = Handler(Looper.getMainLooper())

    init {
        // Start updating city data when ViewModel is created
        updateCity()
    }

    fun getCityData(): LiveData<City> = cityData

    private fun updateCity() {
        Log.e("currentIndex_0",""+currentCityIndex);
        // Update city data
        cityData.value = cities[currentCityIndex]

        // Move to the next city index
        currentCityIndex = (currentCityIndex + 1) % cities.size
        Log.e("currentIndex_1",""+currentCityIndex);
        Log.e("size",""+cities.size);

        // Schedule the next update after the delay
        handler.postDelayed({ updateCity() }, delay)
    }

    override fun onCleared() {
        // Remove any pending callbacks when ViewModel is cleared
        handler.removeCallbacksAndMessages(null)
        super.onCleared()
    }
}
