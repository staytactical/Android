package edu.ourincheon.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

public class NetworkReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // 네트워크 상태 값 받아오기
        if(WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction())){
            NetworkInfo info = (NetworkInfo) intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            NetworkInfo.DetailedState state = info.getDetailedState();
            if(state == NetworkInfo.DetailedState.CONNECTED) { //네트워트 연결상태
                MainActivity.tv_state.setText("네트워크 연결됨");
            } else if ( state == NetworkInfo.DetailedState.DISCONNECTED){
                MainActivity.tv_state.setText("네트워크 연결되지 않음");
            }
        }
    }
}
