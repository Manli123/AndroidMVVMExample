import android.app.Application
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.model.City
import com.example.mvvmexample.model.CityDataProvider

//make available application context in viewmodel for some functionality like accessing system service and all
class CityViewModel(application: Application) : AndroidViewModel(application){

    private val cityData = MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()
    private var currentCityIndex = 0
    private val delay = 2000L

    private val handler = Handler(Looper.getMainLooper())

    init {
        // Start updating city data when ViewModel is created
        updateCity()
        Log.e("use application context in this file",""+application.filesDir)
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
