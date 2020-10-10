package com.turtledove.necropolisofnostalgia.common.quests;

import java.util.ArrayList;
import java.util.List;

public class NecropolisQuestText
{
    //String[] quest_status_text = new String[4];
    List<String[]> quest_status_text = new ArrayList<>();
    public NecropolisQuestText(String[] tText1, String[] tText2, String[] tText3, String[] tText4)
    {
        this.quest_status_text.add(tText1);
        this.quest_status_text.add(tText2);
        this.quest_status_text.add(tText3);
        this.quest_status_text.add(tText4);
    }
    public String getDialogue(int status, int page)
    {
        return this.quest_status_text.get(status)[page];
    }
    public int getStatusLength(int status)
    {
        return this.quest_status_text.get(status).length;
    }
}