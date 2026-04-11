class LRUCache {
public:
    unordered_map<int,pair<int,list<int>::iterator>> mp;
    list<int> lt;
    int cap;

    LRUCache(int capacity) {
        cap = capacity;
        mp.clear();
        lt.clear();
    }
    
    int get(int key) {
        if(mp.count(key)){
            lt.erase(mp[key].second);
            lt.push_front(key);
            mp[key].second = lt.begin();
            return mp[key].first;
        }else{
            return -1;
        }
    }
    
    void put(int key, int value) {
        if(mp.count(key)){
            lt.erase(mp[key].second);
            lt.push_front(key);
            mp[key].second = lt.begin();
            mp[key].first=value;
        }else{
            lt.push_front(key);
            mp[key] = {value,lt.begin()};
        }
        if(mp.size()>cap){
            mp.erase(lt.back());
            lt.pop_back();
        }
    }
};
