package com.morse;

import com.androidsms.MessageInfo;

import java.util.List;

/**
 *
 */
public interface Contact {

    /**
     * @param from
     * @return
     */
    List<MessageInfo> getMessages(String from);

    /**
     * @param from
     * @return
     */
    MessageInfo getLastMessage(String from);

    /**
     *
     */
    void refreshMessageList();

}