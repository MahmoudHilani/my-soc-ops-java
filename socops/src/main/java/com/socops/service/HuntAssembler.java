package com.socops.service;

import com.socops.data.IcebreakerPrompts;
import com.socops.model.HuntItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Builds a fresh Scavenger Hunt checklist from the shared prompt pool. */
public final class HuntAssembler {

    private HuntAssembler() {
        /* static helper — never instantiated */
    }

    /** Produce a shuffled checklist where all items start unchecked. */
    public static List<HuntItem> assembleNewList() {
        List<String> prompts = new ArrayList<>(IcebreakerPrompts.ALL_PROMPTS);
        Collections.shuffle(prompts);

        List<HuntItem> items = new ArrayList<>(prompts.size());
        for (int i = 0; i < prompts.size(); i++) {
            items.add(HuntItem.ofPrompt(i, prompts.get(i)));
        }
        return items;
    }
}
