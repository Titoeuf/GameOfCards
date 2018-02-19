package ca.effenti.gameofcards.webservices;


import ca.effenti.gameofcards.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeckOfCardsServiceFactory {
    public static final String BASE_URL = "https://deckofcardsapi.com/api/";

    private DeckOfCardsServiceFactory() {}

    private static Retrofit retrofit;

    public static DeckOfCardsService getService() {
        if(retrofit==null){
            Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            // Activate Logging interceptor when in DEBUG to view requests and responses in console
            if(BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .build();
                retrofitBuilder.client(client);
            }

            retrofit = retrofitBuilder.build();
        }
        return retrofit.create(DeckOfCardsService.class);
    }
}