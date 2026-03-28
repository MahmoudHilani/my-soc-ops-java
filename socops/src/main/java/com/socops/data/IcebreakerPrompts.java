package com.socops.data;

import java.util.List;

/**
 * Central catalogue of every icebreaker prompt that can appear on a board.
 * Exactly 24 entries — one fewer than the 25-cell grid, because the
 * centre cell is always the free space.
 */
public final class IcebreakerPrompts {

    public static final String FREE_CELL_LABEL = "FREE SPACE";

    public static final List<String> ALL_PROMPTS = List.of(
            "has yelled this is my villain origin story at a loading screen",
            "has won by button-mashing and called it strategy",
            "has made a character that looks nothing like them",
            "has spent longer in character creator than in the game",
            "has celebrated a tiny side quest like a world championship",
            "has gotten emotionally attached to a random NPC",
            "has accidentally skipped the entire tutorial",
            "has jumped in every game because it feels faster",
            "has said one more match and played for two hours",
            "has looted everything that was not nailed down",
            "has screamed after a jump scare then immediately queued again",
            "has named a save file with pure chaos energy",
            "has tried to pet an animal in a game that did not allow it",
            "has walked off a cliff while checking the map",
            "has thanked the healer out loud even in solo mode",
            "has remapped controls and forgotten all of them",
            "has used a meme build and somehow won",
            "has role-played as the team hype person",
            "has taken a screenshot instead of pressing dodge",
            "has challenged someone to rock paper scissors between rounds",
            "has done a dramatic boss fight countdown for friends",
            "has discovered a glitch and called it an advanced mechanic",
            "has invented lore for a completely random item",
            "has taught someone a five-second gaming trick"
    );

    private IcebreakerPrompts() {
        /* catalogue only — no instances */
    }
}
