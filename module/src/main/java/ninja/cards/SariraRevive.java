package ninja.cards;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.android.mods.interfaces.PostUpdateSubscriber;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;

import ninja.enums.CardColorEnum;
import ninja.powers.LexKela;
import ninja.relics.Sarira;

public class SariraRevive extends CustomCard implements PostUpdateSubscriber {
    public static final String IMG_PATH = "img/cards_Ninja/SariraRevive.png";
    public static final String ID = "SariraRevive";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    public SariraRevive() {
        super(ID, NAME, IMG_PATH, 0, DESCRIPTION, AbstractCard.CardType.SKILL, CardColorEnum.SILVER, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
        this.exhaust = true;
        this.upgraded = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        CardCrawlGame.sound.play(ID);
        addToBot(new ApplyPowerAction(p, p, new LexKela(p, 2), 2));
        addToBot(new DrawCardAction(p, 1));
    }

    public void upgrade() {
    }

    public AbstractCard makeCopy() {
        return new SariraRevive();
    }

    private void grantSariraRelic() {
        if (!AbstractDungeon.player.hasRelic(Sarira.ID) && AbstractDungeon.player.gold >= 220) {
            AbstractDungeon.player.gold -= 220;
            CardCrawlGame.sound.play(ID);
            new Sarira();
            AbstractDungeon.topLevelEffects.add(new AbstractGameEffect() { // from class: cards.SariraRevive.1
                public void render(SpriteBatch sb) {
                }

                public void dispose() {
                }

                public void update() {
                    SariraRevive.this.receivePostUpdate();
                    this.isDone = true;
                }
            });
        }
    }

    public void onRemoveFromMasterDeck() {
        grantSariraRelic();
    }

    public void receivePostUpdate() {
        AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2.0f, Settings.HEIGHT / 2.0f, new Sarira());
    }
}
