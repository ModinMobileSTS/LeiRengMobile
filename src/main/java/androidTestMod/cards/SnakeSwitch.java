package androidTestMod.cards;

import androidTestMod.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.actions.unique.RandomizeHandCostAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SnakeSwitch extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("SnakeSwitch");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/SnakeSwitch.png";
    public static final String ID = "SnakeSwitch";

    public SnakeSwitch(){
        super (ID, NAME, IMG_PATH, 0, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 5;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        CardCrawlGame.sound.play("SnakeSwitch");
        //洗牌
        if (!AbstractDungeon.player.discardPile.isEmpty()) {
            this.addToTop(new EmptyDeckShuffleAction());
            this.addToTop(new ShuffleAction(AbstractDungeon.player.drawPile, false));
        }
        //弃牌
        for(AbstractCard c : AbstractDungeon.player.hand.group) {
            if (!c.hasTag(CardTags.NINJUTSU) || c.cardID == "YiCut") {
                this.addToBot(new DiscardSpecificCardAction(c));
            }
        }
        //抽牌
        this.addToBot(new DrawCardAction(this.magicNumber));
        //打乱费用
        this.addToBot(new RandomizeHandCostAction());

    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(2);
        }
    }

    public AbstractCard makeCopy(){
        return new SnakeSwitch();
    }

}
