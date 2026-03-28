package com.socops.model;

/**
 * One checklist item in Scavenger Hunt mode.
 *
 * @param id       zero-based stable item position
 * @param prompt   display text shown in the list
 * @param checked  whether this item has been marked complete
 */
public record HuntItem(int id, String prompt, boolean checked) {

    /** Build an unchecked hunt item. */
    public static HuntItem ofPrompt(int id, String prompt) {
        return new HuntItem(id, prompt, false);
    }
}
