package ninja.cards;

import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

import java.util.ArrayList;
import java.util.List;

public class GodAndBuddha extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("GodAndBuddha");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/GodAndBuddha.png";
    private static final int UPGRADE_PLUS = 1;
    public static final String ID = "GodAndBuddha";

    private List<AbstractCard> derivedCards = new ArrayList<>();
    private int currentPreviewIndex = 0;
    private float timer = 0.0f;
    private static final float INTERVAL = 1.0f;

    public GodAndBuddha() {
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), 0, DESCRIPTION, AbstractCard.CardType.SKILL, CardColorEnum.SILVER, CardRarity.COMMON, AbstractCard.CardTarget.SELF);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true ;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
                List<AbstractCard> foodCards = new ArrayList<>();
        for (AbstractCard card : CardLibrary.getCardList(CardLibrary.LibraryType.COLORLESS)) { // 替换为角色卡池类型
            if (card.hasTag(CardTags.FOOD)) {
                foodCards.add(card);
            }
        }

        if (!foodCards.isEmpty()) {
            // 生成随机索引（修正范围）
            int randomIndex = AbstractDungeon.cardRandomRng.random(foodCards.size() - 1);
            AbstractCard randomFood = foodCards.get(randomIndex).makeCopy();
            addToBot(new MakeTempCardInHandAction(randomFood,  1));
        }
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.exhaust = false;
            this.rawDescription=cardStrings.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    public AbstractCard makeCopy(){
        return new GodAndBuddha();
    }

}
