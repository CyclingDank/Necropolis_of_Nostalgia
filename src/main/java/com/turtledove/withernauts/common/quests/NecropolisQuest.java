package com.turtledove.withernauts.common.quests;

import net.minecraft.item.ItemStack;

public class NecropolisQuest
{
    int questID;
    String questName;
    String questDescription;
    NecropolisQuestText quest_texts;
    ItemStack questStack;
    int questType;   //0 is blueprint quest, 1 is item quest

    public NecropolisQuest(int id, int qType, String name, String description, NecropolisQuestText texts)
    {
        this.questID = id;
        this.questType = qType;
        this.questName = name;
        this.questDescription = description;
        this.quest_texts = texts;
    }

    public NecropolisQuest(int id, int qType, ItemStack tStack, String name, String description, NecropolisQuestText texts)
    {
        this.questID = id;
        this.questType = qType;
        this.questStack = tStack;
        this.questName = name;
        this.questDescription = description;
        this.quest_texts = texts;
    }

    public ItemStack getQuestItemStack()
    {
        return this.questStack;
    }

    public int getQuestType()
    {
        return this.questType;
    }
}
