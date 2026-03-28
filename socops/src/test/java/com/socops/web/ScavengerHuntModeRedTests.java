package com.socops.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Red-phase tests for the new Scavenger Hunt mode contract.
 * These tests intentionally fail until the feature is implemented.
 */
@SpringBootTest
@AutoConfigureMockMvc
class ScavengerHuntModeRedTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Scavenger Hunt endpoint returns a fresh checklist payload")
    void scavengerHuntEndpointReturnsChecklistPayload() throws Exception {
        mockMvc.perform(get("/api/hunt/fresh-list"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(24))
                .andExpect(jsonPath("$[0].id").isNumber())
                .andExpect(jsonPath("$[0].prompt").isString())
                .andExpect(jsonPath("$[0].checked").value(false));
    }

    @Test
    @DisplayName("Game page includes mode selector, hunt checklist, and progress meter hooks")
    void gamePageIncludesScavengerHuntModeHooks() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("modeSelect")))
                .andExpect(content().string(containsString("huntView")))
                .andExpect(content().string(containsString("huntListContainer")))
                .andExpect(content().string(containsString("huntProgressMeter")))
                .andExpect(content().string(containsString("huntProgressText")));
    }

    @Test
    @DisplayName("Active game scene is not nested inside the lobby scene")
    void activeViewIsNotNestedInsideLobbyView() throws Exception {
        MvcResult response = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        String html = response.getResponse().getContentAsString();
        String activeViewParent = nearestNamedParentOf(html, "activeView");

        assertFalse("lobbyView".equals(activeViewParent),
                "activeView must not be hidden as a child of lobbyView");
    }

    @Test
    @DisplayName("Page shell allows vertical scrolling for tall hunt content")
    void pageShellAllowsVerticalScrolling() throws Exception {
        mockMvc.perform(get("/css/app.css"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("overflow-x: hidden;")))
                .andExpect(content().string(containsString("overflow-y: auto;")));
    }

    private static String nearestNamedParentOf(String html, String targetId) throws Exception {
        Deque<String> divStack = new ArrayDeque<>();
        String[] parentId = {null};

        HTMLEditorKit.ParserCallback callback = new HTMLEditorKit.ParserCallback() {
            @Override
            public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
                if (tag == HTML.Tag.DIV) {
                    String id = (String) attributes.getAttribute(HTML.Attribute.ID);
                    if (targetId.equals(id)) {
                        parentId[0] = nearestNamedAncestor(divStack);
                    }
                    divStack.addLast(id == null ? "" : id);
                }
            }

            @Override
            public void handleEndTag(HTML.Tag tag, int position) {
                if (tag == HTML.Tag.DIV && !divStack.isEmpty()) {
                    divStack.removeLast();
                }
            }

            @Override
            public void handleSimpleTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
                // No-op: simple tags cannot contain the target div.
            }
        };

        new ParserDelegator().parse(new StringReader(html), callback, true);
        return parentId[0];
    }

    private static String nearestNamedAncestor(Deque<String> divStack) {
        for (String id : divStack.reversed()) {
            if (!id.isEmpty()) {
                return id;
            }
        }
        return null;
    }
}
