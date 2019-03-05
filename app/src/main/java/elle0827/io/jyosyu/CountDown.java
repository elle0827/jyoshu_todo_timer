package elle0827.io.jyosyu;

import android.os.CountDownTimer;

public class CountDown extends CountDownTimer {
    public CountDown(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        if (onTickListener != null) onTickListener.onTick(millisUntilFinished);
    }

    @Override
    public void onFinish() {
        if (onFinishListener != null) onFinishListener.onFinish();
    }
    public void setOnFinishListener(OnFinishListener onFinishListener) {
        this.onFinishListener = onFinishListener;
    }

    public void setOnTickListener(OnTickListener onTickListener) {
        this.onTickListener = onTickListener;
    }
    OnFinishListener onFinishListener;
        OnTickListener onTickListener;

        // この後の処理を書いて行く
}
