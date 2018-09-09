package com.yeyue.learns.contract;

import com.jess.arms.mvp.IModel;
import com.yeyue.learns.enity.diycode.DiyTopContent;
import com.yeyue.learns.enity.diycode.DiyTopic;
import com.yeyue.library.contract.YeBaseRecyview;
import com.yeyue.library.data.BaseItem;

import java.util.List;

import io.reactivex.Observable;

public interface DiyTopDetailContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View<T> extends YeBaseRecyview<T> {
        void initMarkDown();
        void initDetail(DiyTopContent diyTopContent);
        void initDetail(DiyTopic diyTopic);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<DiyTopContent> getTopicDetail(String id);
        Observable<List<BaseItem>> getTopicRepliesList(int id, Integer offset, Integer limit);
    }
}