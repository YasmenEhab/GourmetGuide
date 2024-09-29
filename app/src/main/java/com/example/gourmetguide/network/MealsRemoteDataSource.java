package com.example.gourmetguide.network;

public interface MealsRemoteDataSource {
    void makeNetworkCall(NetworkCallback networkCallback);
    void makeNetworkCall2(NetworkCallback networkCallback, ApiType apiType);

    enum ApiType {
        RANDOM_MEAL,
        CATEGORY
    }

}
