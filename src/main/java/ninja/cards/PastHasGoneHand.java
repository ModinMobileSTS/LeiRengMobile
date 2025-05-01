package ninja.cards;

import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import ninja.powers.LexKela;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class PastHasGoneHand extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("PastHasGoneHand");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/PastHasGoneHand.png";
    public static final String ID = "PastHasGoneHand";

    public PastHasGoneHand(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 2, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.SELF);
        this.tags.add(CardTags.HAND);
        this.baseBlock = 3;
        this.block =this.baseBlock;
        this.exhaust = true;
        this.tags.add(CardTags.HAND);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m ){
        if (!AbstractDungeon.player.discardPile.isEmpty()) {
                        for (AbstractCard c : AbstractDungeon.player.discardPile.group) {
                // 为每张卡牌添加消耗动作
                this.addToTop(new GainBlockAction(p, this.block));
                this.addToBot(new ApplyPowerAction(p, p, new LexKela(p, 1), 1));
                this.addToBot(new ExhaustSpecificCardAction(c, AbstractDungeon.player.discardPile));
            }
        }
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeBaseCost(1);
        }
    }

    public AbstractCard makeCopy(){
        return new PastHasGoneHand();
    }
}
