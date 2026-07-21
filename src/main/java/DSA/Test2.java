package DSA;

import java.util.concurrent.ConcurrentHashMap;

public class Test2 {

    //fixed window rate limiter
    public static void main(String[] args) throws InterruptedException {

        RateLimiter rateLimiter = new RateLimiter(new FixedWindowRateLimiter(3,1));

        System.out.println(rateLimiter.allowRequest("rupali"));

        System.out.println(rateLimiter.allowRequest("rupali"));

        System.out.println(rateLimiter.allowRequest("rupali"));

        System.out.println(rateLimiter.allowRequest("rupali"));
        Thread.sleep(1000);
        System.out.println(rateLimiter.allowRequest("rupali"));
    }




}


interface RateLimiterStrategy {

    public boolean allowRequest(UserRequest userRequest);

}

class  UserInfo{
    int countOfReq;
    long windowStart;
//    int limitsAllowed;

    public UserInfo(int countOfReq, long windowStart) {
        this.countOfReq = countOfReq;
        this.windowStart = windowStart;
    }
}

class  UserRequest {
    String userId;
    int limitsALlowed;
}
class FixedWindowRateLimiter implements RateLimiterStrategy {

    public int limit;
    public  final long windowSize;
    public ConcurrentHashMap<String,UserInfo> userInfoConcurrentHashMap= new ConcurrentHashMap<>();

    public FixedWindowRateLimiter(int limit, long windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
    }






    @Override
    public boolean allowRequest( UserRequest userRequest) {
        long currTime = System.currentTimeMillis();
        UserInfo userInfo = userInfoConcurrentHashMap.get(userRequest.userId);
        if(userInfo==null){
            userInfoConcurrentHashMap.put(userRequest.userId,new UserInfo(1,currTime));
            return true;
        }

        if(currTime - userInfo.windowStart>= windowSize){
            System.out.println("resetted");
            userInfo.countOfReq=1;
            userInfo.windowStart = currTime;
            return  true;
        }
        if(userInfo.countOfReq<limit){
            System.out.println("allowed");
            userInfo.countOfReq++;
            return  true;
        }
        System.out.println("denied");
        //System.out.println(userInfo.countOfReq + " and " + userInfo.windowStart + " currTime " + currTime);
        return false;
    }
}

class RateLimiter{

    public final RateLimiterStrategy rateLimiterStrategy;

    public RateLimiter(RateLimiterStrategy rateLimiterStrategy) {
        this.rateLimiterStrategy = rateLimiterStrategy;
    }

    public  boolean allowRequest( String cliendId) {
        return rateLimiterStrategy.allowRequest(cliendId);
    }
}